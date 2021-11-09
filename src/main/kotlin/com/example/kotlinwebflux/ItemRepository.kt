package com.example.kotlinwebflux;

import Item
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ItemRepository : ReactiveSortingRepository<Item, Long> {
        //fun findByLogin(login:String):Item?
        @Query("select * from item i")
        open fun findItemsAll(): Flux<Item>
//        @Query("select u,c from Userrrr u join Company c on c.id=u.company.id order by u.id asc ")
//        fun findAllUsers():List<Userrrr>
//
////        fun findAll():List<Userrrr?>
        }
