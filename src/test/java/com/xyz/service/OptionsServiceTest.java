package com.xyz.service;

import com.xyz.Start;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;

public class OptionsServiceTest {

    private OptionsService service = new OptionsService();
    private String filename = "file.txt";

    @Before
    public void readFile() {
        assertThat(filename, is(notNullValue()));
        assertThat(filename, containsString(".txt"));
        service.isReadableFile(filename);
    }

    @Test
    public void countAndOutputQuantityWordAndCharactersWithParameters() {
        String inputString = "-mw " + filename;
        service.validateOptions(inputString);
        assertThat(inputString, containsString("-"));
        assertThat(inputString.length(), is(notNullValue()));
        assertThat(service.countCharacters(), is(229));
        assertThat(service.countWord(), is(37));
    }

    @Test
    public void countAndOutputQuantityWordAndCharactersWithoutParameters() {
        String inputString = filename;
        Start.filename = filename;
        service.validateOptions(inputString);
        assertThat(inputString.length(), is(notNullValue()));
        assertThat(service.countCharacters(), is(229));
        assertThat(service.countWord(), is(37));
    }

    @Test
    public void countAndOutputExtendedStatistics() {
        String inputString = "-X" + filename;
        service.validateOptions(inputString);
        assertThat(inputString, containsString("-"));
        assertThat(inputString.length(), is(notNullValue()));

        String string = "security, policy, that, a, an, actions, A, specifies, be, allowed";
        LinkedHashMap<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(string, 0);
        assertEquals(service.duplicateWords().toString(), expectedResult.keySet().toString());
    }

    @Test
    public void countAndOutputExtendedStatisticsWithQuantityCharacters() {
        String inputString = "-Xm " + filename;
        service.validateOptions(inputString);
        assertThat(inputString, containsString("-"));
        assertThat(inputString.length(), is(notNullValue()));

        String string = "security, policy, that, a, an, actions, A, specifies, be, allowed";
        LinkedHashMap<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(string, 0);
        assertEquals(service.duplicateWords().toString(), expectedResult.keySet().toString());
        assertThat(service.countCharacters(), is(229));
    }
}
