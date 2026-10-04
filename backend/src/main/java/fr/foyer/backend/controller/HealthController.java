package fr.foyer.backend.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // dis à Spring que cette classe expose des endpoints HTTP
@RequestMapping("/api") // ajoute le préfixe commun /api
public class HealthController {

  @GetMapping("/health") // associe la méthode à GET /api/health
  public Map<String, String> health() {
    return Map.of("status", "UP");
  }
}
