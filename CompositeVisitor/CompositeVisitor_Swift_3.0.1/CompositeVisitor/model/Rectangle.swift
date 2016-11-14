//
//  Rectangle.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

class Rectangle : IShape {
    
    private var m_width : Float;
    private var m_height : Float;
    
    init(a_width : Float, a_height : Float) {
        self.m_width = a_width;
        self.m_height = a_height;
    }
    
    func getArea() -> Float {
        return m_height * m_width;
    }
    
    func accept(a_visitor: IShapeVisitor) {
        a_visitor.visitRectangle(a_rect: self);
    }
}
