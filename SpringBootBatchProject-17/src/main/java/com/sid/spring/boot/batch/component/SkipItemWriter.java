/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sid.spring.boot.batch.component;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * @author Lenovo
 */
public class SkipItemWriter implements ItemWriter<String> {

	private int attemptCount = 0;

	@Override
	public void write(List<? extends String> items) throws Exception {
		for (String item : items) {
			if (item.equalsIgnoreCase("-84")) {
				throw new CustomException("Write failed.  Attempt:" + attemptCount);
			} else {
				System.out.println(item);
			}
		}
	}

}
