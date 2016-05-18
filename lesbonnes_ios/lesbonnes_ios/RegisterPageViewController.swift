//
//  RegisterPageViewController.swift
//  lesbonnes_ios
//
//  Created by Yucheng Wang on 4/10/16.
//  Copyright © 2016 Yucheng Wang. All rights reserved.
//

import UIKit

class RegisterPageViewController: UIViewController {

    @IBOutlet weak var userEmailTextField: UITextField!
    @IBOutlet weak var userPasswordTextField: UITextField!
    @IBOutlet weak var repeatPasswordTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func registerButtonTapped(sender: AnyObject) {
        let userEmail = userEmailTextField.text;
        let userPassword = userPasswordTextField.text;
        let userRepeatPassword = repeatPasswordTextField.text;
        
        // check for empy fields
        if (userEmail!.isEmpty || userRepeatPassword!.isEmpty || userPassword!.isEmpty) {
        
            // display alert message
            displayAlertMessage("All fields are required.");
        }
        
        // check if passwords match
        if (userPassword != userRepeatPassword) {
            // display an alert message
            displayAlertMessage("Passwords do not match.");
            return;
        }
    
        // store data
        NSUserDefaults.standardUserDefaults().setObject(userEmail, forKey:"userEmail");
        NSUserDefaults.standardUserDefaults().setObject(userPassword, forKey:"userPassword");
        NSUserDefaults.standardUserDefaults().synchronize();
        
        // display alert message with confirmation
        let myAlert = UIAlertController(title:"Alert", message:"Registration is successful. Thank you!", preferredStyle:UIAlertControllerStyle.Alert);
        let okAction = UIAlertAction(title:"OK", style:UIAlertActionStyle.Default) {
            action in self.dismissViewControllerAnimated(true, completion:nil);
        }
        
        myAlert.addAction(okAction);
        self.presentViewController(myAlert, animated:true, completion:nil);
    }
    
    func displayAlertMessage(userMessage:String) {
        let myAlert = UIAlertController(title:"Alert", message: userMessage, preferredStyle: UIAlertControllerStyle.Alert);
        
        let okAction = UIAlertAction(title:"OK", style: UIAlertActionStyle.Default, handler: nil);
        
        myAlert.addAction(okAction);
        
        self.presentViewController(myAlert, animated: true, completion: nil);
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
