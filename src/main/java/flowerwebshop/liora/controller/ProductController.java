package flowerwebshop.liora.controller;

import flowerwebshop.liora.controller.converter.ProductDtoConverter;
import flowerwebshop.liora.controller.dto.*;
import flowerwebshop.liora.service.product.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private CreateProductUseCase createProductUseCase;
    private UpdateProductUseCase updateProductUseCase;
    private GetProductUseCase getProductUseCase;
    private DeleteProductUseCase deleteProductUseCase;
    private GetAllProductsUseCase getAllProductsUseCase;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        try{
            return ResponseEntity.ok().body(ProductDtoConverter.domainToCreateProductResponse(createProductUseCase.create(ProductDtoConverter.createProductDTOToProduct(request))));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> updateProduct(@RequestBody UpdateProductRequest request) {
        try{

             return ResponseEntity.ok().body(ProductDtoConverter.productToUpdateProductDTO(updateProductUseCase.update(ProductDtoConverter.updateProductDTOToProduct(request))));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable int id) {
        try{
            return ResponseEntity.ok().body(ProductDtoConverter.productToGetProductDTO(getProductUseCase.get(id)));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        try{
            deleteProductUseCase.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<GetAllProductsResponse> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size) {
        try{
            System.out.println("getAllProducts");
            return ResponseEntity.ok().body(GetAllProductsResponse.builder().products(getAllProductsUseCase.getAllProducts(page, size)).build());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
