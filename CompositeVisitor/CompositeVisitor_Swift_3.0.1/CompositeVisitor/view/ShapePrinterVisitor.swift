//
//  ShapePrinterVisitor.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

class ShapePrinterVisitor: IShapeVisitor {
    
    private var m_tabCount : Int;
    
    init() {
        m_tabCount = 0;
    }
    
     func printTabs() {
        for _ in 0...m_tabCount {
            print("\t");
        }
    }
    
    func visitRectangle(a_rect: Rectangle) {
        printTabs();
        print("Rectanlge Area: " + String (a_rect.getArea()));
    }
    
    func visitCircle(a_circle: Circle) {
        printTabs();
        print("Circle Area: " + String (a_circle.getArea()));
    }
    
    func visitCompositePre(a_group: CompositeShape) {
        printTabs();
        print("Composite Total Area: " + String (a_group.getArea()));
        print("Composite parts: ");
        m_tabCount += 1;
    }
    
    func visitCompositePost(a_group: CompositeShape) {
        m_tabCount -= 1;
    }
}
