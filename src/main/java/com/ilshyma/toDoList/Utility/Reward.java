package com.ilshyma.toDoList.Utility;

import com.ilshyma.toDoList.Model.Entity.Task;
import com.ilshyma.toDoList.Model.Entity.enums.Status;
import com.ilshyma.toDoList.repository.TaskRepository;
import com.ilshyma.toDoList.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 10.02.2016.
 */
public class Reward {
    private static final Logger LOGGER = Logger.getLogger(Reward.class);

    public int getCountAllDoneHours(List<Task> list) {
        LOGGER.info("count all done tasks");
        int countAllDoneHours = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus() == Status.DONE) {
                countAllDoneHours = countAllDoneHours + list.get(i).getCountHours();
            }
        }
        LOGGER.info("all done tasks count = " + countAllDoneHours);
            return countAllDoneHours;

    }
}
