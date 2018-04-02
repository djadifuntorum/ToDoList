/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import se.kth.sda3.todolist.filehandler.TaskReader;
import se.kth.sda3.todolist.filehandler.TaskWriter;
import se.kth.sda3.todolist.model.Status;
import se.kth.sda3.todolist.model.Task;

public class DataControllerTest {

    private DataController instance;

    public DataControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new DataController();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoadFileWithData() {
        List<Task> data = new ArrayList<>();
        TaskReader reader = mock(TaskReader.class);

        data.add(new Task("read", "Java", new Date(), Status.NEW));
        when(reader.readFile()).thenReturn(data);
        instance.loadFile(reader);
        int result = instance.getDataSize();

        Assert.assertEquals(1, result);
    }

    @Test
    public void testLoadFileWithoutData() {
        List<Task> data = new ArrayList<>();
        TaskReader reader = mock(TaskReader.class);

        when(reader.readFile()).thenReturn(data);
        instance.loadFile(reader);
        int result = instance.getDataSize();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testWriteFileWithData() {
        TaskWriter writer = mock(TaskWriter.class);

        instance.addData(new Task("read", "Java", new Date(), Status.NEW));
        instance.writeFile(writer);
        verify(writer).writeFile(instance.getData());
    }

    @Test
    public void testWriteFileWithoutData() {
        TaskWriter writer = mock(TaskWriter.class);

        instance.writeFile(writer);
        verify(writer).writeFile(instance.getData());
    }

    @Test
    public void testGetDataWithValidData() {
        Task t1 = new Task("read", "Java", new Date(), Status.NEW);

        instance.addData(t1);
        Assert.assertEquals(t1, instance.getData().get(0));
    }

    @Test
    public void testGetDataWithInvalidData() {
        Task t1 = new Task("read", "Java", new Date(), Status.NEW);
        Task t2 = new Task("read", "Java", new Date(), Status.NEW);
        instance.addData(t1);
        Assert.assertNotEquals(t2, instance.getData().get(0));
    }

    @Test
    public void testAddData() {
        Task t1 = new Task("read", "Java", new Date(), Status.NEW);

        instance.addData(t1);
        Assert.assertEquals(t1, instance.getData().get(0));
    }

    @Test
    public void testGetDataSizeWithCorrectSize() {
        instance.addData(new Task("read", "Java", new Date(), Status.NEW));
        instance.addData(new Task("read", "C++", new Date(), Status.WORKING));

        int result = instance.getDataSize();
        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetDataSizeWithIncorrectSize() {
        instance.addData(new Task("read", "Java", new Date(), Status.NEW));
        instance.addData(new Task("read", "C++", new Date(), Status.WORKING));

        int result = instance.getDataSize();
        Assert.assertNotEquals(1, result);
    }

    @Test
    public void testGetDataByIndexWithCorrectIndex() {
        int index = 0;
        Task t1 = new Task("read", "Java", new Date(), Status.NEW);

        instance.addData(t1);
        Assert.assertEquals(t1, instance.getDataByIndex(index));
    }

    @Test
    public void testGetDataByIndexWithIncorrectIndex() {
        int index = 1;
        Task t1 = new Task("read", "Java", new Date(), Status.NEW);
        Task t2 = new Task("read", "C++", new Date(), Status.WORKING);

        instance.addData(t1);
        instance.addData(t2);
        Assert.assertNotEquals(t1, instance.getDataByIndex(index));
    }

    @Test
    public void testRemoveData() {
        int index = 1;
        Task t1 = new Task("read", "Java", new Date(), Status.NEW);
        Task t2 = new Task("read", "C++", new Date(), Status.WORKING);

        instance.addData(t1);
        instance.addData(t2);
        instance.removeData(index);
        Assert.assertEquals(1, instance.getDataSize());
    }

}
