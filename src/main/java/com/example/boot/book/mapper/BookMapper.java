package com.example.boot.book.mapper;

import com.example.boot.book.dto.BookDTO;
import com.example.boot.book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book toEntity(BookDTO bookDTO);

    @Mapping(target = "id")
    @Mapping(target = "title")
    BookDTO toDTO(Book book);

}
