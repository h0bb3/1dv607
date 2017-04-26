//
//  Circle.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

class Circle:IShape {
    
    private var m_radius : Float;
    
    init(a_rad : Float) {
        m_radius = a_rad;
    }
    
    func getArea() -> Float {
        return m_radius * m_radius * 3.1415;
    }
    
    func accept(a_visitor: IShapeVisitor) {
        a_visitor.visitCircle(a_circle: self);
    }
}
