package com.example.debjit.myrecyclerview;

public class ModuleActivity {
        // Has two properties one is text and another is image resource id
        private String text;
        private String description;
        private int Image;

        //constructor for creating object with resources
        public ModuleActivity(int image, String text){
            this.Image = image;
            this.text = text;
            this.description = description;
        }

        //to get the image resource id, call it
        public int getImage() {
            return Image;
        }

        public void setImage(int image) {
            Image = image;
        }

        //to get the text, call it
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = text;
    }

}