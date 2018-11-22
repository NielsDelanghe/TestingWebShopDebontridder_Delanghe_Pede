package ui.view;

import domain.model.ShopService;

public class HandlerFactory {

    public RequestHandler getController(String key, ShopService model) {
        return createHandler(key, model);
    }

    private RequestHandler createHandler(String handlerName, ShopService model) {
        RequestHandler handler = null;
        try {
            Class<?> handlerClass = Class.forName("ui.view."+ handlerName);
            //Object handlerObject = handlerClass.newInstance();
            // FOR JAVA 10 use
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(model);
        } catch (Exception e) {
            throw new RuntimeException("The requested page doesn’t exist");
        }
        return handler;
    }
}
