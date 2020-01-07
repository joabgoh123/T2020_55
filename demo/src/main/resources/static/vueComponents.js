/*var myObject = new Vue({
    el: '#app',
    data: {message: 'message'}
})
*/

var vm = new Vue({
	el: '#app',
	data: {
		status: '',
		all: '',
		userId: new URLSearchParams(window.location.search).get("id")
	},
	created : function() {
		this.loadUsers();
	},
	methods : {
		loadUsers: function() {
			this.status = 'loading...';
			axios.get("http://localhost:8080/customer?id="+ this.userId)
			.then(function(response){
				vm.all = response.data;
				vm.status = 'done';
			})
			.catch(function(error){
				vm.status = 'error';
			})
		}
	}
});

var vm2 = new Vue({
	el: '#allUsers',
	data: {
		allUsers: '',
	},
	created : function() {
		this.loadUsers();
	},
	methods : {
		loadUsers: function() {
			this.status = 'loading...';
			axios.get("http://localhost:8080/allCustomers")
			.then(function(response){
				vm2.allUsers = response.data;
				console.log(vm2.allUsers);
				$(document).ready( function () {

					$('#allUserTable').DataTable();
				   
				} );
			})
			.catch(function(error){
			})
		}
	}
});

var vm3 = new Vue({
	el: '#allTransactions',
	data: {
		allTransactions: '',
		userIdx: new URLSearchParams(window.location.search).get("id"),
		toDate: new URLSearchParams(window.location.search).get("toDate"),
		fromDate: new URLSearchParams(window.location.search).get("fromDate")

	},
	created : function() {
		this.loadUsers();
	},
	methods : {
		loadUsers: function() {
			this.status = 'loading...';
			axios.get("http://localhost:8080/getTransactions?id="+ this.userIdx+"&fromDate="+this.fromDate+"&toDate="+this.toDate)
			.then(function(response){
				vm3.allTransactions = response.data;
				$(document).ready( function () {
					
					$('#transactionTable').DataTable();
				   
				} );

			})
			.catch(function(error){
			})
		}
	}
});