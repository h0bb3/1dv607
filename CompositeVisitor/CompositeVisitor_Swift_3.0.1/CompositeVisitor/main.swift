//
//  main.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation



func printArea(a_shape : IShape) {
    print("Area is: " + String (a_shape.getArea()));
}

var c = Circle(a_rad : 5.0);
var r = Rectangle(a_width: 5, a_height: 10);
var comp = CompositeShape();

printArea(a_shape: c);
printArea(a_shape: r);

comp.add(a_shape: c);
comp.add(a_shape: r);
printArea(a_shape: comp);

var v = ShapePrinterVisitor();
comp.accept(a_visitor: v);
