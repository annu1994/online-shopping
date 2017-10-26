/*Getting the checkbox element
		Getting the checkbox value return true if checked and false if it is unchecked
		Creating the msg for activation or deactivation of the product.
		Getting the value of the checkbox that is productId.After getting the checkbox value bootbox confirm function is call
		inside the confirm function the callback function is used to checking if the admin confirmed the product activation or deactivation
		the bootbox alert will be shown if the admin cancel the confirm box the checkbox will remain in its current state(ie true or false) 
		*/
$(function() {
	
	/*adminProduct DataTable*/
	var table = $('#adminProductTable');
	 if (table.length) {
	  console.log('inside the table');

	  var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
	  table
	   .DataTable({
	    lengthMenu: [
	     [10, 30, 50, -1],
	     ['10Records', '30Records', '50Records', 'All']
	    ],
	    pageLength: 30,
	    ajax: {
	     url: jsonUrl,
	     dataSrc: '',
	    },
	    columns: [
	    	{
	    		data:'id'
	    	},
	    	{
	      data: 'code',
	      bSortable: false,
	      mRender: function(data, type, row) {

	       return '<img src="' + window.contextRoot + '/webapp/images/' + data + '.jpg" class="adminTableImage"/>';
	      }
	     }, {

	      data: 'name'
	     }, 
	     {
		      data: 'brand'
		     },
	     
	     {
		      data: 'quantity',
		      mRender: function(data, type, row) {
		       if (data < 1) {
		        return '<span style="color:red">Out of stock!</span>';
		       }
		       return data;
		      }
		     },
	     
	     {
	      data: 'unitPrice',
	      mRender: function(data, type, row) {
	       return '&#8377; ' + data
	      }
	     },  {
	      data: 'active',
	      bSortable:false,
	      mRender:function(data,type,row){
	    	  
	    	  var str = '';
	    	  str +='<label class="switch">';
	    	  if(data){
	    		  str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';  
	    	  }
	    	  else{
	    		  str += '<input type="checkbox"  value="'+row.id+'"/>'
	    	  }
	    	  str += '<div class="slider"></div></label>';										
					
	    	  return str;
	    	  
	      }
	      
	     },
	     {
	    	 data:'id',
	    	 bSortable:false,
		     mRender:function(data,type,row){
		    	 var str='';
		    	 
		    	 str +='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
				 str +='<span class="glyphicon glyphicon-pencil"></span></a>';
				 
				 return str;
		     }
		    	  
	     }

	    ],
	    initComplete:function(){
	    	 var api=this.api();
	    	 api.$('.switch input[type="checkbox"]').on('change',function(){
	    			var checkbox=$(this);
	    			var checked=checkbox.prop('checked');
	    			var dMsg=(checked)? 'You want to activate the Product?':
	    								'You want to deactivate the Product?';
	    			var value=checkbox.prop('value');
	    			
	    			bootbox.confirm({
	    				size:'medium',
	    				title:'Product Activation & Deactivation',
	    				message:dMsg,
	    				callback:function(confirmed){
	    					
	    					if(confirmed){
	    						console.log(value);
	    						var prdctActivationUrl= window.contextRoot + '/manage/product/'+value+'/activation';
	    						$.post(prdctActivationUrl,function(data){
	    							bootbox.alert({
		    							size:'medium',
		    							title:'Information',
		    							message:data
		    						});	
	    						});
	    						
	    						
	    					}
	    					else{
	    						checkbox.prop('checked',!checked);
	    					}
	    				}
	    				
	    			});
	    			
	    		});
	    		
	    }
	   });

	 }
	
	
	
});