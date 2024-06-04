package com.foobar;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.bar.domain.Bar;
import com.foobar.bar.repo.BarRepository;
import com.foobar.foo.domain.Foo;
import com.foobar.foo.repo.FooRepository;

@RestController
@RequiredArgsConstructor
public class FooBarController {

	private final FooRepository fooRepo;
	private final BarRepository barRepo;

	@RequestMapping("/foobar/{id}")
	public String fooBar(@PathVariable("id") Long id) {
		Foo foo = fooRepo.findById(id);
		Bar bar = barRepo.findById(id);
		return foo.getFoo() + " " + bar.getBar() + "!";
	}

}

