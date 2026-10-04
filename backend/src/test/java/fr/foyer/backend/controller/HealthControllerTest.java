package fr.foyer.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HealthController.class)  // pour ce test,charge l’environnement Spring nécessaire au web et intéresse-toi à HealthController.
class HealthControllerTest {
    
    // MockMvc est un outil Spring qui permet de simuler des requêtes HTTP.
    @Autowired   // peut se lire : Spring, j’ai besoin d’un MockMvc, donne-moi celui que tu as configuré.
    private MockMvc mockMvc;

    @Test 
    void healthShouldReturnUpStatus() throws Exception {
        mockMvc.perform(get("/api/health")) // Effectue une requête HTTP GET vers /api/health.
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("UP")); // jsonPath permet de naviguer dans du JSON. 
    }
    
    

}
