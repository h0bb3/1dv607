//
//  CompositeShape.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

class CompositeShape: IShape {
    
    private var m_shapes : Array<IShape>;
    
    init() {
        m_shapes = Array<IShape>();
    }
    
    func add(a_shape : IShape) {
        m_shapes.append(a_shape);
    }
    
    func getArea() -> Float {
        var total : Float = 0;
        
        for item in m_shapes {
            total += item.getArea();
        }
        return total;
    }
    
    func accept(a_visitor: IShapeVisitor) {
        a_visitor.visitCompositePre(a_group: self);
        
        for item in m_shapes {
            item.accept(a_visitor: a_visitor);
        }
        a_visitor.visitCompositePost(a_group: self);
    }
}
