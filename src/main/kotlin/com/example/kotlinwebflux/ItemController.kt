package com.example.kotlinwebflux

import Item
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux


@RestController
//@RequestMapping(value = "/items")
class ItemController constructor(var itemRepository: ItemRepository) {

    //private val itemService: ItemService? = null
    //private val itemMapper: ItemMapper? = null

    //@ApiOperation("Create a new item")
    @RequestMapping(value = arrayOf("/"), method = arrayOf(RequestMethod.GET))
    fun create(): Flux<Item> {
        var i: Item = Item(version = 1, description = "hi")
        val save = itemRepository.save(i)
        //.map {ResponseEntity.ok(it)}
        //save.doOnSubscribe { println("subscribed") }
        //save.subscribe { println(System.nanoTime());println(it) }
        //val findItemsAll = itemRepository.findItemsAll()
        return save.doOnEach { println(it) }.toFlux().flatMap{ m -> itemRepository.findItemsAll() }
//        return itemService.create(itemMapper.toModel(newItemResource))
//            .map { item -> created(linkTo(ItemController::class.java).slash(item.getId()).toUri()).build() }
    }
}