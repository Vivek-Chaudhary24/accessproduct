package dev.Vivek.product.Controllers;

import dev.Vivek.product.Dtos.ExceptionDto;
import dev.Vivek.product.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> ProductNotFound(ProductNotFoundException productNotFoundException){
   ExceptionDto exceptionDto = new ExceptionDto();
   exceptionDto.setMessage(productNotFoundException.getMessage());
   exceptionDto.setStatus(HttpStatus.NOT_FOUND);
   return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
