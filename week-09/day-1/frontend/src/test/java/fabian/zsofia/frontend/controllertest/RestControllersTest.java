package fabian.zsofia.frontend.controllertest;

import fabian.zsofia.frontend.controllers.RestControllers;
import fabian.zsofia.frontend.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestControllers.class)
public class RestControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    @Test
    public void doubling_ParamNull_ReturnError() throws Exception {
        mockMvc.perform(get("/doubling"))
                .andExpect(jsonPath("$.error", is("Please provide an input!")));
    }

    @Test
    public void doubling_Param15_Returns30() throws Exception {
        mockMvc.perform(get("/doubling?input=15"))
                .andExpect(jsonPath("$.result", is(30)));
    }

    /*@Test
    public void doubling_Param15_Returns30_AnotherSyntax() throws Exception {
        mockMvc.perform(get("/doubling?input=15"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(30));
    }*/

    @Test
    public void doubling_Param8_Returns16() throws Exception {
        mockMvc.perform(get("/doubling?input=8"))
                .andExpect(jsonPath("$.result", is(16)));
    }

    @Test
    public void greeter_ParamNameAndTitleExist1_ReturnsGreet() throws Exception {
        mockMvc.perform(get("/greeter?name=Petike&title=student"))
                .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Petike, my dear student!")));
    }

    @Test
    public void greeter_ParamNameAndTitleExist2_ReturnsGreet() throws Exception {
        mockMvc.perform(get("/greeter?name=Darth Vader&title=sith"))
                .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Darth Vader, my dear sith!")));
    }

    @Test
    public void greeter_ParamNameExistsTitleMissing_ReturnsTitleError() throws Exception {
        mockMvc.perform(get("/greeter?name=Szabi"))
                .andExpect(jsonPath("$.error", is("Please provide a title!")));
    }

    @Test
    public void greeter_ParamNameMissingTitleExist_ReturnsNameError() throws Exception {
        mockMvc.perform(get("/greeter?title=fool"))
                .andExpect(jsonPath("$.error", is("Please provide a name!")));
    }

    @Test
    public void appendA_PathvarExist1_ReturnsAppendA() throws Exception {
        mockMvc.perform(get("/appenda/zebr"))
                .andExpect(jsonPath("$.appended", is("zebra")));
    }

    @Test
    public void appendA_PathvarExist2_ReturnsAppendA() throws Exception {
        mockMvc.perform(get("/appenda/problem"))
                .andExpect(jsonPath("$.appended", is("problema")));
    }

    @Test
    public void appendA_PathvarMissing_Returns404() throws Exception {
        mockMvc.perform(get("/appenda"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void dountil_PathvarSum1BodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/dountil/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\": 5}"))
                .andExpect(jsonPath("$.result", is(15)));
    }

    @Test
    public void dountil_PathvarSum2BodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/dountil/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\": 25}"))
                .andExpect(jsonPath("$.result", is(325)));
    }

    @Test
    public void dountil_PathvarFactor1BodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/dountil/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\": 5}"))
                .andExpect(jsonPath("$.result", is(15)));
    }

    @Test
    public void dountil_PathvarFactor2BodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/dountil/factor")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"until\": 9}"))
                .andExpect(jsonPath("$.result", is(362880)));
    }

    @Test
    public void dountil_PathvarSumBodyMissing_ReturnsError() throws Exception {
        mockMvc.perform(post("/dountil/sum"))
                .andExpect(jsonPath("$.error", is("Please provide a number!")));
    }

    @Test
    public void dountil_PathvarFactorBodyMissing_ReturnsError() throws Exception {
        mockMvc.perform(post("/dountil/sum"))
                .andExpect(jsonPath("$.error", is("Please provide a number!")));
    }

    @Test
    public void dountil_PathvarMissing_Returns404() throws Exception {
        mockMvc.perform(post("/dountil"))
                .andExpect(status().isNotFound());
    }




}
