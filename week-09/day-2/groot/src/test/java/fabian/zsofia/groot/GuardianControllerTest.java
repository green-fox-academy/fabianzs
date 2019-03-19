package fabian.zsofia.groot;

import fabian.zsofia.groot.controllers.GuardianController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMessage_ParamExist_ReturnsResult() throws Exception {
        mockMvc.perform(get("/groot?message=ooops"))
                .andExpect(jsonPath("$.received", is("ooops")))
                .andExpect(jsonPath("$.translated", is("I am Groot")))
                .andExpect(status().isOk());
    }

    @Test
    public void getMessage_ParamMissing_ReturnsResult() throws Exception {
        mockMvc.perform(get("/groot"))
                .andExpect(jsonPath("$.error", is("I am Groot")))
                .andExpect(status().isOk());
    }
}
