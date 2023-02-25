package com.network.backend.web.controller;

import com.network.backend.web.dto.like.LikeDTOForCreateOrRead;
import com.network.backend.web.dto.like.LikeDTOForUpdate;
import com.network.backend.web.facade.LikeFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeContoller {

    private final LikeFacade likeFasad;

    @PostMapping("/")
    public ResponseEntity<LikeDTOForCreateOrRead> createLike(@Valid @RequestBody LikeDTOForCreateOrRead like){
        return new ResponseEntity<>(likeFasad.saveLike(like), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDTOForCreateOrRead> readLike(@PathVariable long id){
        return new ResponseEntity<>(likeFasad.getLike(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<LikeDTOForUpdate> updateLike(@Valid @RequestBody LikeDTOForUpdate like){
        return new ResponseEntity<>(likeFasad.updateLike(like),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable long id){
        likeFasad.deleteLike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
