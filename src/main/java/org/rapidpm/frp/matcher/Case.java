package org.rapidpm.frp.matcher;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Pair;
import org.rapidpm.frp.model.Result;

/**
 * Copyright (C) 2017 RapidPM - Sven Ruppert
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Created by Sven Ruppert - RapidPM - Team on 16.03.17.
 */
public class Case<T> extends Pair<Supplier<Boolean>, Supplier<Result<T>>> {

  public Case(final Supplier<Boolean> booleanSupplier , final Supplier<Result<T>> resultSupplier) {
    super(booleanSupplier , resultSupplier);
  }

  public static <T> Case<T> matchCase(Supplier<Boolean> condition ,
                                      Supplier<Result<T>> value) {
    return new Case<>(condition , value);
  }

  public static <T> DefaultCase<T> matchCase(Supplier<Result<T>> value) {
    return new DefaultCase<>(() -> true , value);
  }

  public boolean isMatching() {
    return getT1().get();
  }

  public Result<T> result() {
    return getT2().get();
  }

  @SafeVarargs
  public static <T> Result<T> match(DefaultCase<T> defaultCase , Case<T>... matchers) {

    return Stream
        .of(matchers)
        .filter(Case::isMatching)
        .map(Case::result)
        .findFirst()
        .orElseGet(defaultCase::result);
  }

  public static class DefaultCase<T> extends Case<T> {
    public DefaultCase(final Supplier<Boolean> booleanSupplier , final Supplier<Result<T>> resultSupplier) {
      super(booleanSupplier , resultSupplier);
    }
  }
}
