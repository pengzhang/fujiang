import static play.mvc.Results.badRequest;
import static play.mvc.Results.internalServerError;
import static play.mvc.Results.notFound;

import java.lang.reflect.Method;

import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Result;

public class Global extends GlobalSettings {

	public Result onError(Throwable t) {
		return internalServerError("500错误，请重试！");
	}

	public Result onHandlerNotFound(String uri) {
		return notFound("404 你懂的");
	}

	public Result onBadRequest(String uri, String error) {
		return badRequest("URL不存在");
	}

	public Action<?> onRequest(Request request, Method actionMethod) {
		System.out.println("before each request..." + request.toString());
		System.out.println("before each method..." + actionMethod.getName());
		String act = actionMethod.getName();

		if (exceptAction(act)) {
			return super.onRequest(request, actionMethod);
		} else {

			return new Action.Simple() {
				public Result call(Context ctx) throws Throwable {
					System.out.println(ctx.session().get("username"));
					if (ctx.session().get("username") == null || ctx.session().get("username").equals("")) {
						return redirect("/login");
					}
					return delegate.call(ctx);
				}
			};
		}
	}
	
	public boolean exceptAction(String act){
		String[] actions = {"video","login","question","message","create_message","image","success"};
		for(String action:actions){
			if(act.equals(action)){
				return true;
			}
		}
		return false;
	}
	
}
