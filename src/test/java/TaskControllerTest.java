package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSaveTaskWithoutDescription(){
        Task taskWithoutDescription = new Task();
        taskWithoutDescription.setDueDate(LocalDate.now());

        try {
            taskController.save(taskWithoutDescription);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithoutDueDate() {
        Task taskWithoutDueDate= new Task();
        taskWithoutDueDate.setTask("Description");

        try {
            taskController.save(taskWithoutDueDate);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldNotSaveTaskWithPastDueDate() {
        Task taskWithPastDate= new Task();
        taskWithPastDate.setTask("Description");
        taskWithPastDate.setDueDate(LocalDate.of(2010,1, 1));

        try {
            taskController.save(taskWithPastDate);
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void shouldSaveTaskWithSuccess() throws ValidationException {
        Task task = new Task();
        task.setTask("Description");
        task.setDueDate(LocalDate.now());
        taskController.save(task);
        Mockito.verify(taskRepo).save(task);
    }

}
