/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.Fruit;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {

	@Autowired
	FruitRepository repository;

	@GetMapping
	public List<Fruit> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Fruit getFruit(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}

	@PostMapping
	public Fruit createFruit(@RequestBody Fruit fruit) {
		return repository.save(fruit);
	}

	@PutMapping("/{id}")
	public Fruit updateFruit(@PathVariable("id") Long id, @RequestBody Fruit fruit) {
		fruit.setId(id);
		return repository.save(fruit);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.delete(id);
	}

}