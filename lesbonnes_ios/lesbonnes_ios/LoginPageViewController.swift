//
//  LoginPageViewController.swift
//  lesbonnes_ios
//
//  Created by Yucheng Wang on 4/13/16.
//  Copyright © 2016 Yucheng Wang. All rights reserved.
//

import UIKit

class LoginPageViewController: UIViewController {

    @IBOutlet weak var userPasswordTextField: UITextField!
    @IBOutlet weak var userEmailTextField: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func loginButtonTapped(sender: AnyObject) {
        let userEmail = userEmailTextField.text;
        let userPassword = userPasswordTextField.text;
        
        let userEmailStored = NSUserDefaults.standardUserDefaults().stringForKey("userEmail");
        let userPasswordStored = NSUserDefaults.standardUserDefaults().stringForKey("userPassword");
        
        if (userEmailStored == userEmail && userPasswordStored == userPassword) {
            
            // Login is successful
            NSUserDefaults.standardUserDefaults().setBool(true, forKey:"isUserLoggedIn");
            NSUserDefaults.standardUserDefaults().synchronize();
            self.dismissViewControllerAnimated(true, completion:nil);
        }
        
    }
    
    private func loginUser(userEmail: String, userPassword: String, completion: (dict: NSDictionary, message: NSString) -> ()) {
        
//        RestClient().postJSONRawData(<#T##data: NSData##NSData#>, "/user/login") {
//            (returnObject, message) -> () in
//            
//            dispatch_async(dispatch_get_main_queue(), {
//                () -> Void in
//                if returnObject["error"] {
//                    completion(dict: returnObject, message: nil)
//                } else {
//                    var message = "user login error."
//                    completion(dict: returnObject, message: message)
//                }
//            }
//            
//        }
        
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
