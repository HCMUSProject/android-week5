package com.example.week5_fragment;

public class Student {
    private String _id;
    private String _name;
    private Double _score;
    private Integer _img;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Double get_score() {
        return _score;
    }

    public void set_score(Double _score) {
        this._score = _score;
    }

    public Integer get_img() {
        return _img;
    }

    public void set_img(Integer _img) {
        this._img = _img;
    }



    Student(String id, String name, Double score, Integer img) {
        _id = id;
        _name = name;
        _score = score;
        _img = img;
    }
}
