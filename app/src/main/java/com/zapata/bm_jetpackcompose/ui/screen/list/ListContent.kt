package com.zapata.bm_jetpackcompose.ui.screen.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.zapata.bm_jetpackcompose.data.models.Priority
import com.zapata.bm_jetpackcompose.data.models.ToDoTask
import com.zapata.bm_jetpackcompose.ui.theme.*

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
@ExperimentalMaterialApi
@Composable
fun ListContent(
    tasks: List<ToDoTask>,
    navigationToTaskScree: (taskId: Int) -> Unit
) {
    LazyColumn{
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ){ task ->
            TaskItem(toDoTask = task, navigationToTaskScree = navigationToTaskScree)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigationToTaskScree: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackground,
        shape = RectangleShape,
        elevation = TEST_ITEM_ELEVATION,
        onClick = {
            navigationToTaskScree(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)
                    ) {
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun TaskItemPreview() {
    TaskItem(toDoTask = ToDoTask(
        id = 0,
        title = "Title",
        description = "This is the random description",
        priority = Priority.MEDIUM
    ), navigationToTaskScree = {})
}