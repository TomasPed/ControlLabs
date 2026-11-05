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
        return ResponseEntity.ok(List.of(sampleRoom));
    }

    @Override
    public ResponseEntity<RoomResponse> getRoomById(Long id) {
        RoomResponse room = new RoomResponse(
                id, "LAB-" + id, "Laboratorio Computación " + id, 25,
                "Bloque B", "DISPONIBLE", LocalDateTime.now()
        );
        return ResponseEntity.ok(room);
    }

    @Override
    public ResponseEntity<RoomResponse> createRoom(@Valid RoomCreateRequest request) {
         RoomResponse createdRoom = new RoomResponse(
                202L, request.code(), request.name(), request.totalPcs(),
                request.locationBlock(), "REGISTRADO", LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
    }

    @Override
    public ResponseEntity<Void> deleteRoom(Long id) {
      return ResponseEntity.noContent().build();
    }

}