/*
 * Copyright 2013 eXo Platform SAS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bridge.servlet.route.view.pathparampattern;

import juzu.Param;
import juzu.Response;
import juzu.Route;
import juzu.View;
import juzu.test.AbstractTestCase;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class A {

  @View
  public Response.Content index() {

    // First check when it does not match the pattern
    try {
      A_.foo("bar");
      throw AbstractTestCase.failure("Was expecting a failure");
    }
    catch (IllegalArgumentException ignore) {
    }

    //
    return Response.ok("<a id='trigger' href='" + A_.foo("juu") + "'>click</div>");
  }

  @View
  @Route(value = "/foo/{juu}")
  public Response.Content foo(@Param(pattern = "juu") String juu) {
    return Response.ok("" + juu);
  }
}
