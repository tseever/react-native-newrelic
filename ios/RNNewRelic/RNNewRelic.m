//
//  RNNewRelic.m
//  RNNewRelic
//
//  Created by Daniel Zlotin on 26/04/2016.
//  Copyright © 2016 Wix.com. All rights reserved.
//

#import "RNNewRelic.h"

@implementation RNNewRelic

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(send: (NSString*)name :(NSDictionary*)args){
  [NewRelicAgent recordCustomEvent:name attributes:args];
}

RCT_EXPORT_METHOD(recordBreadcrumb: (NSString*)name :(NSDictionary*)args){
  [NewRelicAgent recordBreadcrumb:name attributes:args];
}

RCT_EXPORT_METHOD(startInteraction: (NSString*)name){
  NR_START_NAMED_INTERACTION(name);
}

RCT_EXPORT_METHOD(stopInteraction: (NSString*)name){
  NR_INTERACTION_STOP(name);
}

RCT_EXPORT_METHOD(recordError: (NSString*)name :(NSDictionary*)args){
    NSError *error;
}

RCT_EXPORT_METHOD(setAttribute: (NSString*)name: (NSString*)value){
  [NewRelicAgent setAttribute:name value:value];
}

// Logs a message to the native console
RCT_EXPORT_METHOD(nativeLog:(NSString *)msg){
  NSLog(@"%@", msg);
}

@end
