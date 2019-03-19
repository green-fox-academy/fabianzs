package fabian.zsofia.frontend.controllertest;

import fabian.zsofia.frontend.controllers.RestControllers;
import fabian.zsofia.frontend.models.Log;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
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
        mockMvc.perform(post("/dountil/factor"))
                .andExpect(jsonPath("$.error", is("Please provide a number!")));
    }

    @Test
    public void dountil_PathvarMissing_Returns404() throws Exception {
        mockMvc.perform(post("/dountil"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void arrays_SumBodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"what\": \"sum\", \"numbers\": [1,2,5,10]}"))
                .andExpect(jsonPath("$.result", is(18)));
    }

    @Test
    public void arrays_MultiplyBodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"what\": \"multiply\", \"numbers\": [1,2,5,10]}"))
                .andExpect(jsonPath("$.result", is(100)));
    }

    @Test
    public void arrays_DoubleBodyExist_ReturnsResult() throws Exception {
        mockMvc.perform(post("/arrays")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"what\": \"double\", \"numbers\": [1,2,5,10]}"))
                .andExpect(jsonPath("$.result", is(Arrays.asList(2,4,10,20))));
    }

    @Test
    public void getLogs_ReturnAllLogs_IsOK() throws Exception {
        when(logService.getLogs())
                .thenReturn(new ArrayList<>(Arrays.asList(
                        new Log("/appenda/problem","appendable=problem"),
                        new Log("/doubling", "input=15"))));

        mockMvc.perform(
                get("/log"))
                .andExpect(jsonPath("$.entry_count", is(2)))
                .andExpect(jsonPath("$.entries.[1].createdAt", is(new SimpleDateFormat("yyyy. MM dd. hh:mm:ss").format(new Date()))))
                .andExpect(jsonPath("$.entries.[1].endpoint", is("/doubling")))
                .andExpect(jsonPath("$.entries.[1].data", is("input=15")))
                .andExpect(status().isOk());
    }
}
