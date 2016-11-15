//
//  IShapeVisitor.swift
//  CompositeVisitor
//
//  Created by Sunny Buttar on 2016-11-13.
//  Copyright © 2016 Sarpreet Singh. All rights reserved.
//

import Foundation

protocol IShapeVisitor {
    
    func visitRectangle(a_rect : Rectangle);
    
    func visitCircle(a_circle : Circle);

    func visitCompositePre(a_group : CompositeShape);

    func visitCompositePost(a_group : CompositeShape);
}
