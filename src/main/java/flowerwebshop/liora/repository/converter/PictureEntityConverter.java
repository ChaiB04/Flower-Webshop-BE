package flowerwebshop.liora.repository.converter;

import flowerwebshop.liora.repository.entity.PictureEntity;
import flowerwebshop.liora.repository.entity.ProductEntity;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class PictureEntityConverter {


    public static byte[] convertToByteArray(PictureEntity pictureEntity) {

        return pictureEntity.getPicture();
    }

    public static PictureEntity convertToEntity(byte[] picture, ProductEntity productEntity) {

        return PictureEntity.builder()
                .picture(picture)
                .product(productEntity)
                .build();
    }
}
