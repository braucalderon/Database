// View Controller 

import UIKit

protocol  HomeConnectDelegate {
    func itemsdownloaded(locations:[Location])
}

class ViewController: UIViewController {

    @IBOutlet weak var Selector: UISegmentedControl!
    
    @IBOutlet weak var sigin_label: UILabel!
    
   
    @IBOutlet weak var room: UITextField!
    @IBOutlet weak var last: UITextField!
    
    @IBOutlet weak var LogInButton: UIButton!
    
    var isSelector: Bool = true
    var delegate: HomeConnectDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // Selector
    @IBAction func SelectorAction(_ sender: UISegmentedControl) {
        
        // Flip based on the user input
        isSelector = !isSelector
        
        // Check the bool and set button and labels
        if isSelector{
            sigin_label.text = "Sign In"
            LogInButton.setTitle("Sign In", for: .normal)
        }else{
            sigin_label.text = "Overnight Request"
            LogInButton.setTitle("Send Request", for: .normal)
        }
        
    }
    
    
    // Button
    @IBAction func LoginButtonAction(_ sender: UIButton){
        
       if(isSelector == true){
            
            let url = NSURL(string: "https://braucalderon.com/service.php")!
            var request = URLRequest(url: url as URL)
            request.setValue("application/x-www-form-urlencoded", forHTTPHeaderField: "Content-Type")
            request.httpMethod = "POST"
            
            // Thread 1: Fatal error: Unexpectedly found nil while unwrapping an Optional value
            let parameters = "last=\(_last!)"
            request.httpBody = parameters.data(using: .utf8)
            
            
            let task = URLSession.shared.dataTask(with: request){ data, response, error in
                if error != nil{
                    print("Failed to download")
                }else{
                    
                    self.performSegue(withIdentifier: "main", sender: self)
                    self.parseJason(data!)
                    
                    print("Data downloaded!")
                }
            }
            task.resume()
        }
        
    }
    func parseJason(_ data: Data){
        var locArray = [Location]()
        
        do{
            let jsonArray = try JSONSerialization.jsonObject(with: data, options: []) as! [Any]
            
            
            
            for jsonResult in jsonArray{
                
                let jsonDic = jsonResult as! [String:String]
                
                let loc = Location(firstname: jsonDic["firstname"]!, lastname: jsonDic["lastname"]!, room: jsonDic["room"]!, freenights: jsonDic["freenights"]!, paidnights: jsonDic["paidnights"]!, totalnights: jsonDic["totalnights"]!)
                
                
                locArray.append(loc)
            }
            DispatchQueue.main.async {
                self.delegate?.itemsdownloaded(locations: locArray)
            }
            
            
            
        } catch{
            print ("There was an error")
        }
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
    }
    
}// end class


// Location

import Foundation

struct Location {
    
    var firstname = " "
    var lastname = " "
    var room = " "
    var freenights = " "
    var paidnights = " "
    var totalnights = " "
    
    
}// end class 
