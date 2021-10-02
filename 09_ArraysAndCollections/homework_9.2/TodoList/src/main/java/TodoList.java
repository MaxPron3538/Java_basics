import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Formatter;

public class TodoList {

    private ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo)
    {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if(index < 0 | index > todoList.size()) add(todo);
        else todoList.add(index,todo);

        System.out.println("Добавлено дело "+ todo);
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        String prevToDo = "";

        if(index < 0 | index > todoList.size()){ System.out.println("Дела с таким номером не существует"); return;}
        else {
            prevToDo = todoList.get(index);
            todoList.set(index, todo);
        }
        System.out.println("Дело " + prevToDo + " заменено на " + todo);
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        String deleteElement = "";
        if(index < 0 | index >= todoList.size()){ System.out.println("Дела с таким номером не существует"); return;}
        else deleteElement = todoList.remove(index);

        System.out.println("Дело " + deleteElement + " удалено");
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todoList;
    }

    public void outputList()
    {
        for(int i = 0;i < todoList.size();i++)
        {
            System.out.println(i+1 + " - " + todoList.get(i));
        }
    }

}