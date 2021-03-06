package org.rapidpm.frp.model;

/**
 * Copyright (C) 2010 RapidPM
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
 * Created by RapidPM - Team on 10.12.16.
 */
public class Tripel<T1, T2, T3> {
  private T1 t1;
  private T2 t2;
  private T3 t3;

  public Tripel(final T1 t1, final T2 t2, final T3 t3) {
    this.t1 = t1;
    this.t2 = t2;
    this.t3 = t3;
  }

  public T3 getT3() {
    return t3;
  }

  public T1 getT1() {
    return t1;
  }

  public T2 getT2() {
    return t2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (! (o instanceof Tripel)) return false;

    Tripel<?, ?, ?> tripel = (Tripel<?, ?, ?>) o;

    if (t1 != null ? ! t1.equals(tripel.t1) : tripel.t1 != null) return false;
    if (t2 != null ? ! t2.equals(tripel.t2) : tripel.t2 != null) return false;
    return t3 != null ? t3.equals(tripel.t3) : tripel.t3 == null;
  }

  @Override
  public int hashCode() {
    int result = t1 != null ? t1.hashCode() : 0;
    result = 31 * result + (t2 != null ? t2.hashCode() : 0);
    result = 31 * result + (t3 != null ? t3.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Tripel{" +
        "t1=" + t1 +
        ", t2=" + t2 +
        ", t3=" + t3 +
        '}';
  }

  public static <T1, T2, T3> Tripel<T1, T2, T3> next(final T1 t1, final T2 t2, final T3 t3) {
    return new Tripel<>(t1, t2, t3);
  }
}
