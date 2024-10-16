package controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;

import play.Logger;
import play.libs.concurrent.ClassLoaderExecutionContext;
import play.mvc.*;

public class AsyncController extends Controller {

    private ClassLoaderExecutionContext clExecutionContext;

    @Inject
    public AsyncController(ClassLoaderExecutionContext ec) {
        this.clExecutionContext = ec;
    }

    public CompletionStage<Result> index() {
        // Use a different task with explicit EC
        Logger.debug("in async action..");
        return calculateResponse()
                .thenApplyAsync(
                        answer -> {
                            return ok("answer was " + answer);
                        },
                        clExecutionContext.current());
    }

    private static CompletionStage<String> calculateResponse() {
        return CompletableFuture.completedFuture("42");
    }
}
