//
//  IShape.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

protocol IShape {
    
    func getArea() -> Float;
    
    func accept(a_visitor : IShapeVisitor);
}
