// Connect file
<?php

function db_connect() {
 
    // Define connection as a static variable, to avoid connecting more than once 
    static $connection;
 
    // Try and connect to the database, if a connection has not been established yet
    if(!isset($connection)) {
         // Load configuration as an array. Use the actual location of your configuration file
        $conf = parse_ini_file('../config.ini');
        $connection = mysqli_connect('localhost',$conf['username'],$conf['password'],$conf['dbname']);
        // echo "Connected";
    }
 
    // If connection was not successful, handle the error
    if($connection === false) {
        // Handle error - notify administrator, log to a file, show an error screen, etc.
        return mysqli_connect_error();
    }
    return $connection;
}

// $result = db_connect();

?>

//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------

// Query file

<?php

	include "connect.php";
	
	$encrypt = $_POST["word"];
	
	if ("Abet12!" != $encrypt){
		exit;
		
	} else{
		
	// 	$first = $_POST["first"];
		$last = $_POST["last"];
		$room = $_POST["room"];
// 		$paid = $_POST["paid"];
// 		$free = $_POST["free"];
// 		$total = $_POST["total"];
		
		// create connection
		$conn = db_connect();
		
		// request the query
		$sql = "SELECT `firstname`, `room`, `firstname`,`freenights`, `paidnights`, `totalnights` FROM `Residents` WHERE room= $room  AND lastname= $last"; 
		
		
		
		// check if there are results 
		if($result =  mysqli_query($conn, $sql)){
			
			// create two arrays one to get the results and another to hold the results
// 			$resultarray = array();
			$temparray = array();
// 			while($row = $result->fetch_object()){
//                 // Add each row into our results array
//                 $temparray = $row;
//                  array_push($resultarray, $temparray);
//              }
			
			$row = $result -> fetch_object();
			$temparray = $row;
			
		    echo json_encode($row);
		}
		else{
		
			echo "1";
		}
		
		mysqli_close($con);
	}

?>

//-------------------------------------------------------------------------------------------------------------
// config.ini file 
//------------------------------------------------------------------------------------------------------------- 

[database]
username = "database user"
password = "password"
dbname = "database name"

