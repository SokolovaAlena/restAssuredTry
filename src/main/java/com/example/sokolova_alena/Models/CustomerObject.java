package com.example.sokolova_alena.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class CustomerObject {
    String query;
     Integer page;
     Integer size;
}
