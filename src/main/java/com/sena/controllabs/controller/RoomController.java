package com.sena.controllabs.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sena.controllabs.dto.RoomCreateRequest;
import com.sena.controllabs.dto.RoomResponse;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;

@RestController
public class RoomController implements RoomControllerApi {

    @Override
    public ResponseEntity<List<RoomResponse>> getAllRooms(String block) {
        RoomResponse sampleRoom = new RoomResponse(
                101L, "LAB-301", "Laboratorio Redes SENA", 30,
                block != null ? block : "Bloque A", "DISPONIBLE", LocalDateTime.now()
        );
        RoomResponse sampleRoom1 = new RoomResponse(
                102L, "LAB-302", "Laboratorio Seguridad SENA", 30,
                block != null ? block : "Bloque A", "DISPONIBLE", LocalDateTime.now()
        );
        return ResponseEntity.ok(List.of(sampleRoom,sampleRoom1));
    }

    @Override
    public ResponseEntity<RoomResponse> getRoomById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomById'");
    }

    @Override
    public ResponseEntity<RoomResponse> createRoom(@Valid RoomCreateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRoom'");
    }

    @Override
    public ResponseEntity<Void> deleteRoom(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRoom'");
    }


   
}