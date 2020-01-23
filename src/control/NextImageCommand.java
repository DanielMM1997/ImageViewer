package control;

import model.ImageDisplay;

public class NextImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay){
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        this.imageDisplay.show(this.imageDisplay.current().nextImage());
    }
    
}
