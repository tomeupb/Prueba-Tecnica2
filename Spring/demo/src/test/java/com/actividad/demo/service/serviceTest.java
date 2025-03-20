package com.actividad.demo.service;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.actividad.demo.model.Nave;
import com.actividad.demo.repository.NaveRepository;

@SpringBootTest
public class serviceTest {

    @MockBean
    private NaveRepository naveRepository;

    @Autowired
    private NaveService naveService;


    @Test
    public void buscarNaveId(){

 
   Nave nave1 = new Nave(1, "asd");

   when(naveRepository.findById(nave1.getId())).thenReturn(Optional.of(nave1));

   Nave resultado = naveService.buscarNaveId(nave1.getId());

   assertThat(resultado).isNotNull();

   assertThat(resultado.getNave()).isEqualTo("asd");

   assertThat(resultado.getId()).isEqualTo(1);
      
    
    

    }



}
