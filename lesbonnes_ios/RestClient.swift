////
////  RestClient.swift
////  lesbonnes_ios
////
////  Created by Yucheng Wang on 4/15/16.
////  Copyright © 2016 Yucheng Wang. All rights reserved.
////
//
//import Foundation
//
//typealias JSONDictionary = Dictionary<String, AnyObject>
//typealias JSONArray = Array<AnyObject>
//var dict = NSDictionary(contentsOfFile: NSBundle.mainBundle().pathForResource("config", ofType: "plist")!)
//
//protocol RestClientProtocol {
//    func didRecieveAPIResults(results: NSDictionary?)
//}
//
//class RestClient: NSObject, NSURLConnectionDataDelegate {
//    var delegate: RestClientProtocol?
//    
//    init(delegate: RestClientProtocol?) {
//        self.delegate = delegate
//    }
//    
//    typealias RestCallback = ((NSDictionary?, NSString?) -> ())
//    
//    /**
//       
//      - Paramter
//      - Returns:
//      */
//    internal func getJSONRawData(path: String, callback: RestCallback) {
//        self.makeHTTPGetRequest((getBaseURL(false) as String) + path) {
//            (data, error) -> Void in
//            if (error == nil) {
//                self.delegate?.didRecieveAPIResults(data)
//            }
//        }
//    }
//    
//    /**
//     
//      - Paramter
//      - Returns:
//      */
//    internal func postJSONRawData(data: NSData, path: String, callback: RestCallback) {
//        self.makeHTTPPostRequest((getBaseURL(false) as String) + path, data: <#T##NSData#>) {
//            (data, error) -> Void in
//            if (error == nil) {
//                self.delegate?.didRecieveAPIResults(data)
//            }
//        }
//    }
//
//    /**
//    
//     - Paramter
//     - Returns:
//     */
//    internal func putJSONRawData(data: NSData, path: String, callback: RestCallback) {
//        self.makeHTTPPostRequest((getBaseURL(false) as String) + path, data: <#T##NSData#>) {
//            (data, error) -> Void in
//            if (error == nil) {
//                self.delegate?.didRecieveAPIResults(data)
//            }
//        }
//    }
//
//    /**
//      
//      - Parameter
//      - Returns:
//      */
//    private func getBaseURL(production: Bool) -> NSString {
//        if !production {
//            let configs = dict!["AppConfig_dev"] as! NSDictionary
//            let url = configs["base_url"] as! NSString
//            return url
//        } else {
//            // TODO: add aws server address.
//        }
//    }
//    
//    /**
//      
//      - Parameter
//      - Returns:
//      */
//    private func buildRequestHeaders(request: NSMutableURLRequest) -> NSMutableURLRequest {
//        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
//        request.addValue("application/json", forHTTPHeaderField: "Accept")
//        return request
//    }
//    
//    /**
//    
//      - Parameter
//      - Returns:
//      */
//    private func makeHTTPGetRequest(url: NSString, callback: RestCallback) {
//        let urlObject = NSURL(string: url as String)
//        var request = NSMutableURLRequest(URL: urlObject!)
//        request = self.buildRequestHeaders(request)
//        request.HTTPMethod = "GET"
//        httpRequest(request) {
//            (data, error) -> Void in callback(data, error)
//        }
//    }
//    
//    /**
//    
//      - Parameter
//      - Returns:
//      */
//    private func makeHTTPPostRequest(url: NSString, data: NSData, callback: RestCallback) {
//        let urlObject = NSURL(string: url as String)
//        var request = NSMutableURLRequest(URL: urlObject!)
//        request = self.buildRequestHeaders(request)
//        request.HTTPMethod = "POST"
//        do {
//            request.HTTPBody = try NSJSONSerialization.dataWithJSONObject(data, options: .PrettyPrinted)
//            httpRequest(request) {
//                (data, error) -> Void in callback(data, error)
//            }
//        } catch {
//            // TODO: add personal errors.
//            callback(nil, "http post request error.")
//        }
//    }
//    
//    /**
//    
//     - Parameter
//     - Returns:
//     */
//    private func makeHTTPPutRequest(url: NSString, data: NSData, callback: RestCallback) {
//        let urlObject = NSURL(string: url as String)
//        var request = NSMutableURLRequest(URL: urlObject!)
//        request = self.buildRequestHeaders(request)
//        request.HTTPMethod = "PUT"
//        do {
//            request.HTTPBody = try NSJSONSerialization.dataWithJSONObject(data, options: .PrettyPrinted)
//            httpRequest(request) {
//                (data, error) -> Void in callback(data, error)
//            }
//        } catch {
//            // TODO: add personal errors.
//            callback(nil, "http post request error.")
//        }
//    }
//    
//    /**
//    
//      - Paramter
//      - Returns:
//      */
//    func httpRequest(request: NSURLRequest!, callback: RestCallback) {
//        let session = NSURLSession(configuration: NSURLSessionConfiguration.defaultSessionConfiguration())
//        
//        session.dataTaskWithRequest(request) {
//            (data, response, error) -> Void in
//            if let data = data {
//                let json = try? NSJSONSerialization.JSONObjectWithData(data, options: [])
//                if let jsonDict = json as? NSDictionary {
//                    if let response = response as? NSHTTPURLResponse where 200...299 ~= response.statusCode {
//                        callback(jsonDict, nil)
//                    } else {
//                        callback(jsonDict, "httpRequest error.")
//                    }
//                } else {
//                    callback(nil, "httpRequest can not convert json to dict")
//                }
//            }
//        }.resume()
//    }
//}
