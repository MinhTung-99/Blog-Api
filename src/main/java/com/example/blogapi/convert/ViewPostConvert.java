package com.example.blogapi.convert;

import com.example.blogapi.dto.ViewPostDTO;
import com.example.blogapi.entity.ViewPostEntity;
import org.springframework.stereotype.Component;

@Component
public class ViewPostConvert {

    public ViewPostEntity toEntity (ViewPostDTO viewPostDTO) {
        ViewPostEntity viewPostEntity = new ViewPostEntity();
        viewPostEntity.setIdUser(viewPostDTO.getIdUser());
        viewPostEntity.setIdPost(viewPostDTO.getIdPost());

        return viewPostEntity;
    }

    public ViewPostDTO toDTO (ViewPostEntity viewPostEntity) {
        ViewPostDTO viewPostDTO = new ViewPostDTO();
        viewPostDTO.setIdPost(viewPostEntity.getIdPost());
        viewPostDTO.setIdUser(viewPostEntity.getIdUser());

        return viewPostDTO;
    }
}
