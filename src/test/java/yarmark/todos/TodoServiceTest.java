package yarmark.todos;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoServiceTest {
	@Test
	public void testListTodos() throws IOException {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com")
		// retrofit doesn't know what gson is
		// need gson converter
		// and converter gson to the dependency
				.addConverterFactory(GsonConverterFactory.create()).build();

		TodoService service = retrofit.create(TodoService.class);

		Call<List<Todo>> call = service.listTodos();
		// a call can execute and enqueue
		Response<List<Todo>> response = call.execute();
		List<Todo> list = response.body();

		// test should verify that you download 200 todo items

		assertEquals(200, list.size());
	}
}
