package com.example.jewelryshop.Controller;

import com.example.jewelryshop.Dto.ItemPagingDto;
import com.example.jewelryshop.Dto.ItemRequestDto;
import com.example.jewelryshop.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemDatabaseController {

    private final ItemService itemService;

    public ItemDatabaseController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> postItem(@Valid @RequestBody ItemRequestDto requestDto) {
        itemService.post(requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteItem(@PathVariable long id) {
        boolean result = itemService.delete(id);
        if(result)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/items")
    public ResponseEntity<ItemPagingDto> getAllItems(
            @RequestParam(name = "pageNumber") Integer pageNumber,
            @RequestParam(name = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(itemService.getAll(pageNumber, pageSize));
    }
}
