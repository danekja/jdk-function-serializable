/*
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Jakub Danek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *
 *  Please visit https://github.com/danekja/jdk-function-serializable if you need additional information or have any
 *  questions.
 *
 */

package org.danekja.java.util.function.serializable;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntConsumer;

/**
 * Serializable version of {@link IntConsumer}
 *
 * @author Jakub Danek (www.danekja.org)
 */
@FunctionalInterface
public interface SerializableIntConsumer extends IntConsumer, Serializable {
	/**
	 * Returns a composed {@code SerializableIntConsumer} that performs, in sequence,
	 * this operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation.  If performing this operation throws an exception,
	 * the {@code after} operation will not be performed.
	 *
	 * @param after the operation to perform after this operation
	 * @return a composed {@code SerializableIntConsumer} that performs in sequence
	 * this operation followed by the {@code after} operation
	 * @throws NullPointerException if {@code after} is null
	 */
	default SerializableIntConsumer andThen(SerializableIntConsumer after) {
		Objects.requireNonNull(after);
		return (int t) -> {
			accept(t);
			after.accept(t);
		};
	}
}
