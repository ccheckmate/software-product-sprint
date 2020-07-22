// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*; 

/** Servlet that returns some example content. TODO: modify this file to handle comments data */

@WebServlet("/my-data-url")
public class DataServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    ArrayList<String>messages = new ArrayList<String>();

    messages.add("Hey It is so nice to see you here!");
    messages.add("I am Karishma");
    messages.add("You are Welcome");

    String json = convertToJsonUsingGson(messages);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);

  }

   //Converts the list of messages into a JSON string using manual String concatentation using the Gson library.

    private String convertToJsonUsingGson(ArrayList<String>messages) {
    Gson gson = new Gson();
    String json = gson.toJson(messages);
    return json;
  }
}
